package com.linderaredux.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.linderaredux.BR
import com.linderaredux.R
import com.linderaredux.base.BaseActivity
import com.linderaredux.databinding.ActivityLandingBinding
import com.linderaredux.databinding.ActivityLoginBinding
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginNavigator {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    @set:Inject
    override var viewModel: LoginViewModel? = null

    private var mActivityLoginBinding: ActivityLoginBinding? = null

    override val bindingVariable: Int
        get() = BR.viewModel

    override val isFullScreen: Boolean
        get() = false

    override val layoutId: Int
        get() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityLoginBinding = getViewDataBinding()
        viewModel?.setNavigator(this)
    }

    override fun handleError(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_SHORT).show();
    }

    override fun onInternetConnectionError() {
        Toast.makeText(
                applicationContext,
                getString(R.string.please_check_your_internet_connection_or_try_again_later),
                Toast.LENGTH_SHORT
        ).show()
    }
}