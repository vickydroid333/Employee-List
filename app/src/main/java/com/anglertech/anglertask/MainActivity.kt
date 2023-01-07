package com.anglertech.anglertask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anglertech.anglertask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmployeeAdapter
    private lateinit var employeeList: ArrayList<EmployeeListModel>
    private var name: Array<String>? = null
    private var mobile: Array<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        employeeList = arrayListOf()
        name = arrayOf(
            "Vignesh M",
            "Prem Kumar",
            "Tamil Selvan",
            "Saravanan",
            "Nagarasu",
            "Muthu Karthikeyan",
            "Selva Kumar",
            "Dinesh Kumar",
            "Lokesh Kumar",
            "John Micheal",
            "Kalaivanan",
            "Bharanidharan",
            "Boopathy",
            "Sri Kannan",
            "Vimal Raj",
            "Suresh Kumar",
            "Ram Kumar",
            "Sekaran",
            "Selva Ganapathy",
            "Viswa"
        )

        mobile = arrayOf(
            "9876543210",
            "8973563383",
            "7836436399",
            "6365674894",
            "9764367488",
            "9863564765",
            "9745664773",
            "9473567766",
            "6375489479",
            "6397898786",
            "7574674848",
            "6383733997",
            "9476287929",
            "9746749388",
            "7497487347",
            "9467478748",
            "9378398399",
            "9398373980",
            "9564746373",
            "8973563383",

            )
        adapter = EmployeeAdapter(employeeList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)

        getData()

    }

    private fun getData() {
        for (i in name!!.indices) {
            val empDetails = EmployeeListModel(name?.get(i), mobile?.get(i))
            employeeList.add(empDetails)
        }
    }
}