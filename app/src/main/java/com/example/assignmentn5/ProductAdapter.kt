package com.example.assignmentn5

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter (private val products: List<ProductModel>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.nameTextView.text = product.name
        holder.productEditButton.setOnClickListener {
            val productAddActivity = Intent(it.context, ProductAddActivity::class.java)
            productAddActivity.putExtra("productId", product.id)
            it.context.startActivity(productAddActivity)
        }

    }

    override fun getItemCount(): Int {
        return products.size
    }

    class ViewHolder(productView: View): RecyclerView.ViewHolder(productView) {
        val nameTextView: TextView = productView.findViewById(R.id.textView)
        val productEditButton: Button = productView.findViewById(R.id.productEditButton)
    }
}