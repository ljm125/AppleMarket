package com.android.applemarket

import android.content.Intent
import android.os.Build.VERSION_CODES.M
import android.os.Build.VERSION_CODES.P
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.applemarket.databinding.ItemRecyclerviewBinding

class MyAdapter(val Items:MutableList<MyItem>) : RecyclerView.Adapter<MyAdapter.Holder>(){

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding = ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {
        holder.bind(Items[position])
    }

    override fun getItemCount(): Int {
        return Items.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    inner class Holder(val binding: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){
        private val context = binding.root.context

        fun bind(item:MyItem) {
            binding.ivImage.setImageResource(item.image)
            binding.tvName.text = item.name
            binding.tvLocation.text = item.location
            binding.tvMoney.text = item.money
            binding.tvChatCount.text = item.chat.toString()
            binding.tvHeartCount.text = item.heart.toString()

            itemView.setOnClickListener {
                val intent = Intent(context, ProductActivity::class.java)
                intent.putExtra("item",item)
                intent.run { context.startActivity(this) }
            }
        }

    }
}