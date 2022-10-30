package me.project.typewriter.ui



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import me.project.typewriter.databinding.ArticleItemLayoutBinding
import me.project.typewriter.model.Article

class ArticleItemAdapter(private val onItemClicked: (Article) -> Unit) :
    RecyclerView.Adapter<ArticleViewHolder>() {

    private var articleList = mutableListOf<Article>()

    fun setArticleList(articleList: List<Article>) {

        this.articleList = articleList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemLayoutBinding.inflate(inflater, parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articleList[position]
        holder.bind(article, onItemClicked)

    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}

class ArticleViewHolder(private val binding: ArticleItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article, onItemClicked: (Article) -> Unit) {

        binding.txtTitle.text = article.title
        binding.txtResume.text = article.resume
        binding.txtAuthor.text= article.User.username
        binding.imgDelete.setOnClickListener {

        }
        itemView.setOnClickListener {
            onItemClicked(article)

        }
    }
}

