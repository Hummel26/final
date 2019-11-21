package com.burapha.a59160359


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.burapha.a59160359.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)

        val adapter = HomeAdapter()

        val data = listOf(
            Computer(1,"MSI ALPHA 15 A3DD-014TH","CPU : AMD RYZEN 7 3750H\n" +
                    "RAM : 8 GB DDR4 2666MHz\n" +
                    "STORAGE : 512 GB PCIe/NVMe M.2 SSD\n" +
                    "DISPLAY : 15.6\" FULL HD IPS 120Hz\n" +
                    "VGA : AMD RADEON RX 5500M 4 GB GDDR6\n" +
                    "OS : WINDOWS 10 HOME"),
            Computer(2,"ACER ASPIRE A315-22-48AL","CPU : AMD A4-9120E\n" +
                    "RAM : 4 GB DDR4\n" +
                    "STORAGE : 1 TB 5400 RPM\n" +
                    "DISPLAY : 15.6\" HD\n" +
                    "VGA : INTEGRATED\n" +
                    "OS : WINDOWS 10 HOME"),
            Computer(3,"ASUS VIVOBOOK 15 EJ039T","CPU : AMD RYZEN 5 3500U\n" +
                    "RAM : 4 GB DDR4\n" +
                    "STORAGE : 1 TB 5400 RPM\n" +
                    "DISPLAY : 15.6\" FULL HD ANTI-GLARE\n" +
                    "VGA : AMD RADEON VEGA 8\n" +
                    "OS : WINDOWS 10"),
            Computer(4,"ASUS VIVOBOOK 15 EJ139T","CPU : AMD RYZEN 5 3500U\n" +
                    "RAM : 8 GB DDR4\n" +
                    "STORAGE : 512 GB PCIe/NVMe M.2 SSD\n" +
                    "DISPLAY : 15.6\" FULL HD ANTI-GLARE\n" +
                    "VGA : AMD RADEON VEGA 8\n" +
                    "OS : WINDOWS 10"),
            Computer(5,"ASUS VIVOBOOK 15 EJ141T","CPU : AMD RYZEN 5 3500U\n" +
                    "RAM : 8 GB DDR4\n" +
                    "STORAGE : 512 GB PCIe/NVMe M.2 SSD\n" +
                    "DISPLAY : 15.6\" FULL HD ANTI-GLARE\n" +
                    "VGA : AMD RADEON VEGA 8\n" +
                    "OS : WINDOWS 10"),
            Computer(6,"ASUS VIVOBOOK 15 EJ314T","CPU : AMD RYZEN 5 3500U\n" +
                    "RAM : 4 GB DDR4\n" +
                    "STORAGE : 1 TB 5400 RPM\n" +
                    "DISPLAY : 15.6\" FULL HD TN ANTI-GLARE\n" +
                    "VGA : AMD RADEON VEGA 8\n" +
                    "OS : WINDOWS 10"),
            Computer(7,"LENOVO IDEAPAD","CPU : INTEL CORE I5-10210U\n" +
                    "RAM : 8 GB (4GB X2) DDR4 2666MHz\n" +
                    "STORAGE : 512 GB PCIe/NVMe M.2 SSD\n" +
                    "DISPLAY : 14\" FULL HD IPS ANTI-GLARE\n" +
                    "VGA : NVIDIA GEFORCE MX250 2 GB GDDR5\n" +
                    "OS : WINDOWS 10 HOME + OFFICE HOME & STUDENT 2019"),
            Computer(8,"DELL INSPIRON","CPU : INTEL CORE I7-9750H\n" +
                    "RAM : 8 GB DDR4 2666MHz\n" +
                    "STORAGE : 512 GB PCIe/NVMe M.2 SSD\n" +
                    "DISPLAY : 15.6\" FULL HD ANTI-GLARE\n" +
                    "VGA : NVIDIA GEFORCE GTX1650 4 GB GDDR5\n" +
                    "OS : WINDOWS 10 HOME"),
            Computer(9,"HUAWEI MATEBOOK","CPU : INTEL CORE I7-8565U\n" +
                    "RAM : 8 GB LPDDR3\n" +
                    "STORAGE : 512 GB SSD PCIe/NVMe\n" +
                    "DISPLAY : 13\" FULL HD\n" +
                    "VGA : NVIDIA GEFORCE MX150 2 GB GDDR5\n" +
                    "OS : WINDOWS 10 HOME"),
            Computer(10,"HUAWEI XPRO","CPU : INTEL CORE I7-8550U\n" +
                    "RAM : 16 GB LPDDR3\n" +
                    "STORAGE : 512 GB SSD PCIe/NVMe\n" +
                    "DISPLAY : 13.9\" FULL HD\n" +
                    "VGA : NVIDIA GEFORCE MX150 2 GB GDDR5\n" +
                    "OS : WINDOWS 10")
        )

        adapter.data = data
        binding.recycleView.adapter = adapter
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


}
