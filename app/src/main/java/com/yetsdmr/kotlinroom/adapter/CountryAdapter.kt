package com.yetsdmr.kotlinroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yetsdmr.kotlinroom.R
import com.yetsdmr.kotlinroom.databinding.ItemCountryBinding
import com.yetsdmr.kotlinroom.model.Country
import com.yetsdmr.kotlinroom.util.downloadFromUrl
import com.yetsdmr.kotlinroom.util.placeholderProgressBar
import com.yetsdmr.kotlinroom.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>) :

    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {


    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CountryAdapter.CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(
            inflater,
            R.layout.item_country,
            parent,
            false
        )
        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CountryAdapter.CountryViewHolder, position: Int) {
        holder.view.country = countryList[position]
        holder.view.listener = this

        /*
      holder.view.name.text = countryList[position].countryName
      holder.view.region.text = countryList[position].countryRegion
      holder.view.setOnClickListener {
          val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
          //action.countryUuid
          Navigation.findNavController(it).navigate(action)
      }
      holder.view.imageView.downloadFromUrl(countryList[position].imageUrl, placeholderProgressBar(holder.view.context))
*/
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClicked(v: View) {
        val uuid = v.countryUuidText.text.toString().toInt()
       val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(uuid)
       //action.countryUuid
        Navigation.findNavController(v).navigate(action)


    }
}