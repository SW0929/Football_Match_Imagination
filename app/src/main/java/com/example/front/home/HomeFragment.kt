package com.example.front.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.front.R
import com.example.front.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

class HomeFragment: Fragment(R.layout.fragment_home) {

    private var binding: FragmentHomeBinding? = null
    private lateinit var articleAdapter: ArticleAdapter

    private val articleList = mutableListOf<ArticleModel>()
    //1. 리스트에 넣어서(add) submitList에 추가

    //todo 로그인 확인
    //todo db등록

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentHomeBinding = FragmentHomeBinding.bind(view)
        binding = fragmentHomeBinding

        articleList.clear() //초기화

        articleAdapter = ArticleAdapter()
        //1 번 하면 아래 3줄 필요없음
        articleAdapter.submitList(mutableListOf<ArticleModel>().apply {
            //db랑 연동해서 하기
            add(ArticleModel("0", "aaaa", 1000000, "aaaa", ""))
            add(ArticleModel("0", "bbbb", 2000000, "bbbb", ""))
        })

        //fragment 자체는 context가 될 수 없음
        fragmentHomeBinding.articleRecyclerView.layoutManager = LinearLayoutManager(context)
        fragmentHomeBinding.articleRecyclerView.adapter = articleAdapter

        //회원가입 한 유저만 가능
        fragmentHomeBinding.addFloatingButton.setOnClickListener {
            context?.let {
                //todo 로그인 기능 구현 후에 주석 지우기
                if (true){//(유저가 회원인지 확인)
                    val intent = Intent(it, AddArticleActivity::class.java)
                    startActivity(intent)
                } else {
                    Snackbar.make(view, "로그인 후 사용해주세요.", Snackbar.LENGTH_LONG).show()
                }
            }

        }

    }
    //뷰가 생성될 때 마다 attach하고 제거될 때 remove

    override fun onDestroy() {
        super.onDestroy()

        //todo 이벤트 리스너 제거(전역 변수로 해야함)
    }

    override fun onResume() {
        super.onResume()
        //뷰를 다시 그림
        articleAdapter.notifyDataSetChanged()

    }
}