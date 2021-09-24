package com.example.demo.views.view.fragments.dashboard.viewholders

import android.view.View
import com.example.demo.databinding.ItemDetailBinding
import com.example.common.base.BaseViewHolder
import com.example.common.base.ViewHolderBindingProperty
import com.example.common.interfaces.DashBoardListener
import com.example.common.data.ListItemDetails
import com.example.common.model.ListItems

class DetailsViewHolder(val view: View) :
    BaseViewHolder(view) {

    private val binding by ViewHolderBindingProperty(ItemDetailBinding::bind)
    private var articleClickListener : DashBoardListener? = null

    override fun bind(data: ListItems) {
        val article = (data as? ListItemDetails)?.articles
        binding.details = article
        binding.ivImage.setOnClickListener {
            article?.let { it1 -> articleClickListener?.onClickArticle(it1) }
        }
    }

    override fun setListener(listener: DashBoardListener) {
        this.articleClickListener = listener
    }

}