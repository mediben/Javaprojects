package android.support.v4.os;

import android.os.Parcel;

public interface ParcelableCompatCreatorCallbacks {

   Object createFromParcel(Parcel var1, ClassLoader var2);

   Object[] newArray(int var1);
}
