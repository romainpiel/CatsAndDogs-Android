package com.romainpiel.catsanddogs

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.threeten.bp.*
import org.threeten.bp.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var disposable: Disposable
    private lateinit var adapter: ItemAdapter
    private var dateMenuItem: MenuItem? = null
    private var timeMenuItem: MenuItem? = null
    private var dateFilter: LocalDate? = null
    private var timeFilter: LocalTime? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ItemAdapter()
        val recyclerView = findViewById(R.id.recycler_view_main) as? RecyclerView
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this)

        refreshSchedule()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        dateMenuItem = menu?.findItem(R.id.date)
        timeMenuItem = menu?.findItem(R.id.time)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (dateFilter == null) {
            dateMenuItem?.title = getString(R.string.date)
        } else {
            dateMenuItem?.title = dateFilter?.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        }
        if (timeFilter == null) {
            timeMenuItem?.title = getString(R.string.time)
        } else {
            timeMenuItem?.title = timeFilter?.format(DateTimeFormatter.ofPattern("HH:mm"))
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.date -> {
                showDatePicker()
                return true
            }
            R.id.time -> {
                showTimePicker()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

    private fun showDatePicker() {
        val base = dateFilter ?: LocalDate.now()
        val listener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            dateFilter = LocalDate.of(year, month + 1, dayOfMonth)
            supportInvalidateOptionsMenu()
            refreshSchedule()
        }
        DatePickerDialog(this, listener, base.year, base.monthValue - 1, base.dayOfMonth).show()
    }

    private fun showTimePicker() {
        val base = timeFilter ?: LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            timeFilter = LocalTime.of(hourOfDay, minute)
            supportInvalidateOptionsMenu()
            refreshSchedule()
        }
        TimePickerDialog(this, listener, base.hour, base.minute, true).show()
    }

    private fun refreshSchedule() {
        val from = if (dateFilter != null && timeFilter != null) {
            val zoneOffset = ZoneId.systemDefault().rules.getOffset(Instant.now())
            OffsetDateTime.of(dateFilter, timeFilter, zoneOffset).toString()
        } else {
            null
        }
        disposable = ScheduleRepository().schedule(from)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ adapter.items = it }, { Log.e("MainActivity", "Could not load schedule", it) })
    }
}
