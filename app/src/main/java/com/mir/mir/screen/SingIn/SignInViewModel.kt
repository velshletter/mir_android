package com.mir.mir.screen.SingIn


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mir.mir.data.retrofit.repository.AuthRepository
import com.mir.mir.data.retrofit.repository.UserProfileRepository
import com.mir.mir.domain.retrofit.usecases.auth.LoginUseCase
import com.mir.mir.domain.retrofit.usecases.auth.LogoutUseCase
import com.mir.mir.domain.retrofit.usecases.auth.RegisterUseCase
import com.mir.mir.domain.retrofit.usecases.user.GetProfileUseCase
import com.mir.mir.domain.retrofit.usecases.user.UpdateProfileUseCase
import kotlinx.coroutines.launch

class SignInViewModel(): ViewModel() {
    private val authRepository: AuthRepository = AuthRepository()
    private val authLoginUseCase: LoginUseCase = LoginUseCase(authRepository = authRepository)
    private val authRegisterUseCase: RegisterUseCase = RegisterUseCase(authRepository = authRepository)
    private val logoutUseCase: LogoutUseCase = LogoutUseCase(authRepository = authRepository)

    private val userRepository: UserProfileRepository = UserProfileRepository()
    private val getProfileUseCase = GetProfileUseCase(userRepository)
    private val updateProfileUseCase = UpdateProfileUseCase(userRepository)


    private val _responseLiveData = MutableLiveData<String>()
    val responseLiveData: LiveData<String> = _responseLiveData
    // ливдата для тестов, мб можно что-то другое
    fun postAuthLogin(name: String, password: String){
        viewModelScope.launch {
            try {
                authLoginUseCase.invoke(name, password)

            } catch (e: Exception) {
                _responseLiveData.value = "Error occurred: ${e.message}"
                Log.d("MyLog", _responseLiveData.value!!)
            }
        }
    }

    fun postAuthLogout(){
        viewModelScope.launch {
            try {
                logoutUseCase.invoke()
            } catch (e: Exception) {
                _responseLiveData.value = "Error occurred: ${e.message}"
                Log.d("MyLog", _responseLiveData.value!!)
            }
        }
    }

    fun postAuthRegister(email: String, password: String){
        viewModelScope.launch {
            try {
                val response = authRegisterUseCase.invoke(email = email, password = password)
//                _responseLiveData.value = response.toString()
//                Log.d("MyLog", _responseLiveData.value!!)
                //val cookies = cookieManager.cookieStore.cookies
                //Log.d("MyLog", cookies.toString())
            } catch (e: Exception) {
                _responseLiveData.value = "Error occurred: ${e.message}"
                Log.d("MyLog", _responseLiveData.value!!)
            }
        }
    }

    fun getUserProfile(){
        viewModelScope.launch {
            try {
                val response = getProfileUseCase.invoke()
                //_responseLiveData.value = response.toString()
                Log.d("MyLog", response.toString())
            } catch (e: Exception) {
                _responseLiveData.value = "Error occurred: ${e.message}"
                Log.d("MyLog", _responseLiveData.value!!)
            }
        }
    }

    fun updateUserProfile(searchRangeMin: Int, searchRangeMax: Int,
                          searchAgeMin: Int, searchAgeMax: Int){
        viewModelScope.launch {
            try {
                val response = updateProfileUseCase.invoke(searchRangeMin,  searchRangeMax,
                     searchAgeMin,  searchAgeMax)
                //_responseLiveData.value = response.toString()
                Log.d("MyLog", response.toString())
            } catch (e: Exception) {
                _responseLiveData.value = "Error occurred: ${e.message}"
                Log.d("MyLog", _responseLiveData.value!!)
            }
        }
    }
}