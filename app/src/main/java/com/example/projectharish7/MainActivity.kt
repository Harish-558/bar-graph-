package com.example.projectharish7// Your package name

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. FIND THE CHART
        val barChart = findViewById<BarChart>(R.id.barChart)

        // --- PASTE DATA POINTS START HERE ---
        val entries = ArrayList<BarEntry>()
        entries.add(BarEntry(1f, 10f))
        entries.add(BarEntry(2f, 40f))
        entries.add(BarEntry(3f, 60f))
        entries.add(BarEntry(4f, 30f))
        entries.add(BarEntry(5f, 90f))
        // --- PASTE DATA POINTS END HERE ---

        // 2. CONNECT TO DATASET
        val dataSet = BarDataSet(entries, "Weekly Sales")
        dataSet.color = Color.parseColor("#4CAF50") // A nice green color
        dataSet.valueTextSize = 12f

        // 3. SET DATA TO CHART
        val barData = BarData(dataSet)
        barChart.data = barData

        // 4. REFRESH
        barChart.invalidate()

        // 1. Add a smooth animation (Bars will "grow" up for 2 seconds)
        barChart.animateY(2000)

// 2. Remove the "Description Label" (The small text at the bottom right)
        barChart.description.isEnabled = false

// 3. Customize the X-Axis (The bottom line)
        val xAxis = barChart.xAxis
        xAxis.setDrawGridLines(false) // Hide vertical lines for a cleaner look
        xAxis.position = com.github.mikephil.charting.components.XAxis.XAxisPosition.BOTTOM

// 4. Customize the Y-Axis (The left line)
        val leftAxis = barChart.axisLeft
        leftAxis.setDrawGridLines(true) // Keep horizontal lines to help read values
        leftAxis.axisMinimum = 0f // Start the scale at zero

        barChart.setTouchEnabled(true)
        barChart.isDragEnabled = true
        barChart.setScaleEnabled(true)
    }

}