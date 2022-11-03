package com.example.assignmentn5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ProductAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_add)
        val databaseHelper = ProductDatabaseHelper(this)

        val productId = intent.getIntExtra("productId", -1)

        val nameEditText = findViewById<EditText>(R.id.editTextProductName)
        val descriptionEditText = findViewById<EditText>(R.id.editTextTextMultiLine)
        val deleteButton = findViewById<Button>(R.id.buttonDeleteProduct)

        if (productId > -1) {
            val product = databaseHelper.getProduct(productId)
            nameEditText.setText(product.name)
            descriptionEditText.setText(product.description)

            deleteButton.setOnClickListener {
                databaseHelper.deleteProduct(productId)
                startMainActivity()
            }
        } else {
            deleteButton.visibility = View.INVISIBLE
        }

        findViewById<Button>(R.id.buttonSaveProduct).setOnClickListener {
            if (productId > -1) {
                val product = ProductModel(
                    id = null,
                    name = nameEditText.text.toString(),
                    description = descriptionEditText.text.toString()
                )
                databaseHelper.updateProduct(productId, product)
            } else {
                val product = ProductModel(
                    id = null,
                    name = nameEditText.text.toString(),
                    description = descriptionEditText.text.toString()
                )
                databaseHelper.addProduct(product)
            }
            startMainActivity()
        }
    }

    fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}