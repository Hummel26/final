package com.burapha.a59160359


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.burapha.a59160359.databinding.FragmentDetailBinding

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false)
        val arguments = arguments?.let { DetailFragmentArgs.fromBundle(it) }

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

        binding.titleTxt.text = data[arguments!!.id].title
        binding.descTxt.text = data[arguments!!.id].description
        binding.imageView.setImageResource( when (data[arguments!!.id].id) {
            1 -> R.drawable.alpha
            2 -> R.drawable.aspire
            3 -> R.drawable.ej039t
            4 -> R.drawable.ej139t
            5 -> R.drawable.ej141t
            6 -> R.drawable.ej314t
            7 -> R.drawable.ideapad
            8 -> R.drawable.inspiron
            9 -> R.drawable.matebook
            10 -> R.drawable.xpro
            else -> R.drawable.ic_launcher_background
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item!!.itemId) {R.id.share -> shareSuccess()
        }
        return NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController()) ||super.onOptionsItemSelected(item)
    }

    private fun getShareIntent() : Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, "Share to:")
        return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share, menu)

        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {

            menu.findItem(R.id.share)?.isVisible = false
        }
    }


}
