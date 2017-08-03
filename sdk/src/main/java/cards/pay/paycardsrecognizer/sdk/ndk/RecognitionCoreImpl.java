package cards.pay.paycardsrecognizer.sdk.ndk;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.view.Display;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public interface RecognitionCoreImpl {

    void setStatusListener(@Nullable RecognitionStatusListener listener);

    void setTorchStatus(boolean isTurnedOn);

    void setTorchListener(@Nullable TorchStatusListener listener);

    void setRecognitionMode(@RecognitionConstants.RecognitionMode int mode);

    void setCameraSensorOrientation(int rotation);

    // XXX must be called after setCameraSensorOrientation()
    void setDisplayParameters(Display display);

    void calcWorkingArea(int width, int height, int captureAreaWidth);

    Rect getCardFrameRect();

    @RecognitionConstants.DetectedBorderFlags
    int processFrameYV12(int width, int height, byte buffer[]);

    void resetResult();

    void setIdle(boolean isIdle);

    boolean isIdle();

}
