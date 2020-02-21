package mvvm.livedata.example.viewmodel.factory

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinpractice.UserEntity
import com.example.kotlinpractice.UserViewModel


class UserViewModelFactory(private val context: Context, private val user: UserEntity,private val application: Application) :
    ViewModelProvider.NewInstanceFactory() {

    @Override
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(context, user,application) as T
    }
}