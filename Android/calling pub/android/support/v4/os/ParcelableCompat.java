package android.support.v4.os;

import android.os.Parcel;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.os.ParcelableCompatCreatorHoneycombMR2Stub;

public class ParcelableCompat {

   public static Creator newCreator(ParcelableCompatCreatorCallbacks var0) {
      if(VERSION.SDK_INT >= 13) {
         ParcelableCompatCreatorHoneycombMR2Stub.instantiate(var0);
      }

      return new ParcelableCompat.CompatCreator(var0);
   }

   static class CompatCreator implements Creator {

      final ParcelableCompatCreatorCallbacks mCallbacks;


      public CompatCreator(ParcelableCompatCreatorCallbacks var1) {
         this.mCallbacks = var1;
      }

      public Object createFromParcel(Parcel var1) {
         return this.mCallbacks.createFromParcel(var1, (ClassLoader)null);
      }

      public Object[] newArray(int var1) {
         return this.mCallbacks.newArray(var1);
      }
   }
}
