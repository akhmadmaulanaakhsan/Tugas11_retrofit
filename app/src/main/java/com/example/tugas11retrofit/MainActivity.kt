import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas11retrofit.NewsAdapter
import com.example.tugas11retrofit.databinding.ActivityMainBinding
import com.example.tugas11retrofit.model.DataNews
import com.example.tugas11retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Inisialisasi adapter
        newsAdapter = NewsAdapter(emptyList())

        // Mengatur RecyclerView dengan LinearLayoutManager
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = newsAdapter

        // Mengambil data dari API menggunakan Retrofit
        val client = ApiClient.getInstance()
        val response = client.getAllNews()

        response.enqueue(object : Callback<DataNews> {
            override fun onResponse(call: Call<DataNews>, response: Response<DataNews>) {
                if (response.isSuccessful) {
                    val dataNews = response.body()?.data ?: emptyList()
                    newsAdapter.setData(dataNews)
                } else {
                    showToast("Gagal mendapatkan data")
                }
            }

            override fun onFailure(call: Call<DataNews>, t: Throwable) {
                showToast("Koneksi error: ${t.message}")
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}




