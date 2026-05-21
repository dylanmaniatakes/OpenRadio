package Y;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.AbstractC0409x1;

/* loaded from: classes.dex */
public final class f extends AbstractC0409x1 {

    /* renamed from: c, reason: collision with root package name */
    public final TextView f2876c;

    /* renamed from: d, reason: collision with root package name */
    public final d f2877d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2878e = true;

    public f(TextView textView) {
        this.f2876c = textView;
        this.f2877d = new d(textView);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC0409x1
    public final InputFilter[] i(InputFilter[] inputFilterArr) {
        if (!this.f2878e) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i5 = 0; i5 < inputFilterArr.length; i5++) {
                InputFilter inputFilter = inputFilterArr[i5];
                if (inputFilter instanceof d) {
                    sparseArray.put(i5, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                if (sparseArray.indexOfKey(i7) < 0) {
                    inputFilterArr2[i6] = inputFilterArr[i7];
                    i6++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i8 = 0;
        while (true) {
            d dVar = this.f2877d;
            if (i8 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = dVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i8] == dVar) {
                return inputFilterArr;
            }
            i8++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC0409x1
    public final void l(boolean z4) {
        if (z4) {
            p();
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC0409x1
    public final void m(boolean z4) {
        this.f2878e = z4;
        p();
        TextView textView = this.f2876c;
        textView.setFilters(i(textView.getFilters()));
    }

    public final void p() {
        TextView textView = this.f2876c;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (this.f2878e) {
            if (!(transformationMethod instanceof j) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                transformationMethod = new j(transformationMethod);
            }
        } else if (transformationMethod instanceof j) {
            transformationMethod = ((j) transformationMethod).f2885a;
        }
        textView.setTransformationMethod(transformationMethod);
    }
}
