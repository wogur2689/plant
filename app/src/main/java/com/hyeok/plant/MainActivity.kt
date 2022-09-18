package com.hyeok.plant

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import com.hyeok.plant.base.BaseActivity
import com.hyeok.plant.databinding.ActivityMainBinding
import com.hyeok.plant.imgSearch.ImgSearchActivity
import com.hyeok.plant.search.SearchActivity

class MainActivity : BaseActivity<ActivityMainBinding>({
    ActivityMainBinding.inflate(it)
}) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recommedBtn.setOnClickListener {
            toast("오늘의 식물 추천")
        }
        binding.searchBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        binding.imgSearchBtn.setOnClickListener {
           /* if(checkCameraHardware()) {
                toast("기기에 카메라가 있어야 사용이 가능합니다!")
                return@setOnClickListener
            }*/

            //if(getCameraInstance() == null) {
              //  toast("카메라를 사용할 수 없습니다.")
            //    return@setOnClickListener
            //}

            val intent = Intent(this, ImgSearchActivity::class.java)
            startActivity(intent)
        }
    }

    /* 기기에 카메라가 있는지 체크 */
    /*private fun checkCameraHardware(): Boolean {
        return packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
    }*/

    /* 카메라 사용 권한 요청 */
    /*private fun getCameraInstance(): CameraDevice? {
        /*return try {

        } catch (e: Exception) {
            null
        }*/
    }*/
}