package com.example.basicbudget.Adapters

import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.basicbudget.R
import kotlinx.android.synthetic.main.create_transaction.view.*
import kotlinx.android.synthetic.main.sub_category_view.view.*
import java.text.DecimalFormat

class SubCategoryAdapter(val sub_categories: List<String>, val main_category: String ) : RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): SubCategoryViewHolder {
        return SubCategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sub_category_view, parent, false)
        )
    }

    override fun getItemCount() = sub_categories.size

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {

        holder.view.textView.text = sub_categories[position]

        holder.view.setOnClickListener {
            val subCategory = holder.view.sub_category_card.textView.text.toString()

            val mDialogView = LayoutInflater.from(holder.view.context).inflate(R.layout.create_transaction, null)
            val mBuilder = AlertDialog.Builder(holder.view.context)
                .setView(mDialogView)
                .setTitle("$main_category - $subCategory")

            val mAlertDialog = mBuilder.show()
            mAlertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

            mDialogView.create_tx_okBtn.setOnClickListener {
                val txAmount = mDialogView.create_tx_editText.text.toString().toFloat()
                mAlertDialog.dismiss()
            }

            mDialogView.create_tx_CancelBtn.setOnClickListener{
                mAlertDialog.dismiss()
            }
        }
    }

    class SubCategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}