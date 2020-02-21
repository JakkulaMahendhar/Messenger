package com.example.kotlinpractice.databinding;
import com.example.kotlinpractice.R;
import com.example.kotlinpractice.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding implements com.example.kotlinpractice.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.layout_login_1, 6);
        sViewsWithIds.put(R.id.layout_login_2, 7);
        sViewsWithIds.put(R.id.txtForgotPwd, 8);
        sViewsWithIds.put(R.id.or, 9);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final androidx.appcompat.widget.AppCompatButton mboundView4;
    @NonNull
    private final androidx.appcompat.widget.AppCompatTextView mboundView5;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    // values
    // listeners
    private OnClickListenerImpl mUserviewmodelOnLoginClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener tvEmailandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userviewmodel.userDo1.email
            //         is userviewmodel.userDo1.setEmail((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(tvEmail);
            // localize variables for thread safety
            // userviewmodel != null
            boolean userviewmodelJavaLangObjectNull = false;
            // userviewmodel.userDo1.email
            java.lang.String userviewmodelUserDo1Email = null;
            // userviewmodel.userDo1 != null
            boolean userviewmodelUserDo1JavaLangObjectNull = false;
            // userviewmodel.userDo1
            com.example.kotlinpractice.UserEntity userviewmodelUserDo1 = null;
            // userviewmodel
            com.example.kotlinpractice.UserViewModel userviewmodel = mUserviewmodel;



            userviewmodelJavaLangObjectNull = (userviewmodel) != (null);
            if (userviewmodelJavaLangObjectNull) {


                userviewmodelUserDo1 = userviewmodel.getUserDo1();

                userviewmodelUserDo1JavaLangObjectNull = (userviewmodelUserDo1) != (null);
                if (userviewmodelUserDo1JavaLangObjectNull) {




                    userviewmodelUserDo1.setEmail(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener tvPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of userviewmodel.userDo1.password
            //         is userviewmodel.userDo1.setPassword((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(tvPassword);
            // localize variables for thread safety
            // userviewmodel != null
            boolean userviewmodelJavaLangObjectNull = false;
            // userviewmodel.userDo1 != null
            boolean userviewmodelUserDo1JavaLangObjectNull = false;
            // userviewmodel.userDo1.password
            java.lang.String userviewmodelUserDo1Password = null;
            // userviewmodel.userDo1
            com.example.kotlinpractice.UserEntity userviewmodelUserDo1 = null;
            // userviewmodel
            com.example.kotlinpractice.UserViewModel userviewmodel = mUserviewmodel;



            userviewmodelJavaLangObjectNull = (userviewmodel) != (null);
            if (userviewmodelJavaLangObjectNull) {


                userviewmodelUserDo1 = userviewmodel.getUserDo1();

                userviewmodelUserDo1JavaLangObjectNull = (userviewmodelUserDo1) != (null);
                if (userviewmodelUserDo1JavaLangObjectNull) {




                    userviewmodelUserDo1.setPassword(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[9]
            , (com.example.kotlinpractice.DrawableEditText) bindings[1]
            , (com.example.kotlinpractice.DrawableEditText) bindings[2]
            , (android.widget.TextView) bindings[8]
            );
        this.btnSignup.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (androidx.appcompat.widget.AppCompatButton) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (androidx.appcompat.widget.AppCompatTextView) bindings[5];
        this.mboundView5.setTag(null);
        this.tvEmail.setTag(null);
        this.tvPassword.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new com.example.kotlinpractice.generated.callback.OnClickListener(this, 1);
        mCallback4 = new com.example.kotlinpractice.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.userviewmodel == variableId) {
            setUserviewmodel((com.example.kotlinpractice.UserViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUserviewmodel(@Nullable com.example.kotlinpractice.UserViewModel Userviewmodel) {
        this.mUserviewmodel = Userviewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.userviewmodel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String userviewmodelUserDo1Email = null;
        java.lang.String userviewmodelUserDo1Password = null;
        com.example.kotlinpractice.UserEntity userviewmodelUserDo1 = null;
        android.view.View.OnClickListener userviewmodelOnLoginClickAndroidViewViewOnClickListener = null;
        com.example.kotlinpractice.UserViewModel userviewmodel = mUserviewmodel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (userviewmodel != null) {
                    // read userviewmodel.userDo1
                    userviewmodelUserDo1 = userviewmodel.getUserDo1();
                    // read userviewmodel::onLoginClick
                    userviewmodelOnLoginClickAndroidViewViewOnClickListener = (((mUserviewmodelOnLoginClickAndroidViewViewOnClickListener == null) ? (mUserviewmodelOnLoginClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mUserviewmodelOnLoginClickAndroidViewViewOnClickListener).setValue(userviewmodel));
                }


                if (userviewmodelUserDo1 != null) {
                    // read userviewmodel.userDo1.email
                    userviewmodelUserDo1Email = userviewmodelUserDo1.getEmail();
                    // read userviewmodel.userDo1.password
                    userviewmodelUserDo1Password = userviewmodelUserDo1.getPassword();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.btnSignup.setOnClickListener(userviewmodelOnLoginClickAndroidViewViewOnClickListener);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvEmail, userviewmodelUserDo1Email);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvPassword, userviewmodelUserDo1Password);
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.mboundView4.setOnClickListener(mCallback3);
            this.mboundView5.setOnClickListener(mCallback4);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.tvEmail, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, tvEmailandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.tvPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, tvPasswordandroidTextAttrChanged);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private com.example.kotlinpractice.UserViewModel value;
        public OnClickListenerImpl setValue(com.example.kotlinpractice.UserViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onLoginClick(arg0); 
        }
    }
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // userviewmodel != null
                boolean userviewmodelJavaLangObjectNull = false;
                // userviewmodel
                com.example.kotlinpractice.UserViewModel userviewmodel = mUserviewmodel;



                userviewmodelJavaLangObjectNull = (userviewmodel) != (null);
                if (userviewmodelJavaLangObjectNull) {


                    userviewmodel.onSkipClick();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // userviewmodel != null
                boolean userviewmodelJavaLangObjectNull = false;
                // userviewmodel
                com.example.kotlinpractice.UserViewModel userviewmodel = mUserviewmodel;



                userviewmodelJavaLangObjectNull = (userviewmodel) != (null);
                if (userviewmodelJavaLangObjectNull) {


                    userviewmodel.onMobileVerification();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): userviewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}