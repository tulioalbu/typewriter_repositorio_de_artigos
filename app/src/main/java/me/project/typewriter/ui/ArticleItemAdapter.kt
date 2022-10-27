package me.project.typewriter.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.project.typewriter.databinding.ArticleItemLayoutBinding
import me.project.typewriter.model.Article

class ArticleItemAdapter(private val onItemClicked: (Article) -> Unit) :
    RecyclerView.Adapter<MainViewHolder>() {

    private var articleList = mutableListOf<Article>()

    @SuppressLint("NotifyDataSetChanged")
    fun setArticleList(lives: List<Article>) {

        this.articleList = lives.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemLayoutBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val live = articleList[position]
        holder.bind(live, onItemClicked)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}

class MainViewHolder(val binding: ArticleItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article, onItemClicked: (Article) -> Unit) {

        binding.txtTitle.text = article.title
        binding.txtResume.text = article.resume
        binding.txtAuthor.text= article.user.username
        binding.txtSize.text = article.user.username

        itemView.setOnClickListener {
            onItemClicked(article)
        }

    }

}
