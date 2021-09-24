package com.example.demo.views.view.fragments.dashboard.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import com.example.demo.R
import com.example.demo.databinding.ItemMainNewsBinding
import com.example.common.base.BaseViewHolder
import com.example.common.base.ViewHolderBindingProperty
import com.example.common.interfaces.DashBoardListener
import com.example.common.data.ListItemMainNews
import com.example.common.model.ListItems

class MainNewsViewHolder(val view: View) :
    BaseViewHolder(view) {

    private val binding by ViewHolderBindingProperty(ItemMainNewsBinding::bind)
    private var articleClickListener : DashBoardListener? = null

    override fun bind(data: ListItems) {
        val article = (data as? ListItemMainNews)?.article
        binding.mainNews = article
        binding.ivImage.setOnClickListener {
            article?.let { it1 -> articleClickListener?.onClickArticle(it1) }
        }
        binding.ivBookmark.setOnClickListener{
            article?.let { it1 -> articleClickListener?.onClickBookmark(it1) }
        }
        if(article?.isBookmarked == true){
            binding.ivBookmark.setColorFilter(ContextCompat.getColor(view.context, R.color.purple_700))
        }else{
            binding.ivBookmark.setColorFilter(ContextCompat.getColor(view.context, R.color.clr_575757))

        }
    }

    override fun setListener(listener: DashBoardListener) {
        this.articleClickListener = listener
    }

}