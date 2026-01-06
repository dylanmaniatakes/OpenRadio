package j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public class C extends f.u implements Menu {

    /* renamed from: c, reason: collision with root package name */
    public final m f7378c;

    public C(Context context, m mVar) {
        super(context);
        if (mVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f7378c = mVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return f(this.f7378c.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f7378c.addIntentOptions(i5, i6, i7, componentName, intentArr, intent, i8, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i9 = 0; i9 < length; i9++) {
                menuItemArr[i9] = f(menuItemArr2[i9]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f7378c.addSubMenu(charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        q.k kVar = (q.k) this.f6369b;
        if (kVar != null) {
            kVar.clear();
        }
        this.f7378c.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f7378c.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i5) {
        return f(this.f7378c.findItem(i5));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i5) {
        return f(this.f7378c.getItem(i5));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f7378c.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return this.f7378c.isShortcutKey(i5, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i5, int i6) {
        return this.f7378c.performIdentifierAction(i5, i6);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        return this.f7378c.performShortcut(i5, keyEvent, i6);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i5) {
        if (((q.k) this.f6369b) != null) {
            int i6 = 0;
            while (true) {
                q.k kVar = (q.k) this.f6369b;
                if (i6 >= kVar.f9278l) {
                    break;
                }
                if (((G.a) kVar.h(i6)).getGroupId() == i5) {
                    ((q.k) this.f6369b).i(i6);
                    i6--;
                }
                i6++;
            }
        }
        this.f7378c.removeGroup(i5);
    }

    @Override // android.view.Menu
    public final void removeItem(int i5) {
        if (((q.k) this.f6369b) != null) {
            int i6 = 0;
            while (true) {
                q.k kVar = (q.k) this.f6369b;
                if (i6 >= kVar.f9278l) {
                    break;
                }
                if (((G.a) kVar.h(i6)).getItemId() == i5) {
                    ((q.k) this.f6369b).i(i6);
                    break;
                }
                i6++;
            }
        }
        this.f7378c.removeItem(i5);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i5, boolean z4, boolean z5) {
        this.f7378c.setGroupCheckable(i5, z4, z5);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i5, boolean z4) {
        this.f7378c.setGroupEnabled(i5, z4);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i5, boolean z4) {
        this.f7378c.setGroupVisible(i5, z4);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z4) {
        this.f7378c.setQwertyMode(z4);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f7378c.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5) {
        return f(this.f7378c.add(i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5) {
        return this.f7378c.addSubMenu(i5);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return f(this.f7378c.add(i5, i6, i7, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        return this.f7378c.addSubMenu(i5, i6, i7, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, int i8) {
        return f(this.f7378c.add(i5, i6, i7, i8));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return this.f7378c.addSubMenu(i5, i6, i7, i8);
    }
}
