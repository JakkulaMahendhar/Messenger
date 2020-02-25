package com.example.kotlinpractice.databinding;
import com.example.kotlinpractice.R;
import com.example.kotlinpractice.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBindingImpl extends ActivityMainBinding implements com.example.kotlinpractice.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.img_wallet, 4);
        sViewsWithIds.put(R.id.mywallet, 5);
        sViewsWithIds.put(R.id.user_tag, 6);
        sViewsWithIds.put(R.id.et_email, 7);
        sViewsWithIds.put(R.id.email, 8);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ActivityMainBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[3]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[8]
            , (android.widget.EditText) bindings[7]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[6]
            );
        this.btnSignout.setTag(null);
        this.editImg.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.kotlinpractice.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.example.kotlinpractice.generated.callback.OnClickListener(this, 2);
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
        if (BR.mainviewmodel == variableId) {
            setMainviewmodel((com.example.kotlinpractice.MainActivityViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMainviewmodel(@Nullable com.example.kotlinpractice.MainActivityViewModel Mainviewmodel) {
        this.mMainviewmodel = Mainviewmodel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.mainviewmodel);
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
        com.example.kotlinpractice.MainActivityViewModel mainviewmodel = mMainviewmodel;
        // batch finished
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.btnSignout.setOnClickListener(mCallback2);
            this.editImg.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // mainviewmodel
                com.example.kotlinpractice.MainActivityViewModel mainviewmodel = mMainviewmodel;
                // mainviewmodel != null
                boolean mainviewmodelJavaLangObjectNull = false;



                mainviewmodelJavaLangObjectNull = (mainviewmodel) != (null);
                if (mainviewmodelJavaLangObjectNull) {


                    mainviewmodel.editClick();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // mainviewmodel
                com.example.kotlinpractice.MainActivityViewModel mainviewmodel = mMainviewmodel;
                // mainviewmodel != null
                boolean mainviewmodelJavaLangObjectNull = false;



                mainviewmodelJavaLangObjectNull = (mainviewmodel) != (null);
                if (mainviewmodelJavaLangObjectNull) {


                    mainviewmodel.signOutClick();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): mainviewmodel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}