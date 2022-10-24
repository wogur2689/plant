package com.hyeok.plant.imgSearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.databinding.ActivityPreviewBinding


class PreviewActivity : BaseActivity<ActivityPreviewBinding> ({
    ActivityPreviewBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val cameraIntent: Intent = intent

        //이미지 받아오기
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/plant/" + cameraIntent.getStringExtra("image")
        startActivityForResult(intent, 1)

        //다시 캡쳐
        binding.btnReplay.setOnClickListener {
            val intent1 = Intent(this, CameraActivity::class.java)
            startActivity(intent1)
        }
        //이미지로 검색하기
        binding.btnSearch.setOnClickListener {
            val intent2 = Intent(this, ImgSearchActivity::class.java)
            startActivity(intent2)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val uri: Uri? = data?.data
            binding.captureImg.setImageURI(uri)
        } else {
            Log.d("preview", "error")
            toast("이미지 업로드에 실패하였습니다.")
        }
    }
}
