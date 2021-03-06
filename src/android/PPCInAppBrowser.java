package com.ppc.browser;
import android.content.Intent;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class PPCInAppBrowser extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        if (action.equals("openBrowser")) {
            String message = args.getString(0);
            this.openBrowser(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
    private void openBrowser(String message, CallbackContext callbackContext) {


        if (message != null && message.length() > 0) {
            Intent i = new Intent(cordova.getActivity(),com.ppc.browser.TestActivity.class);
            i.putExtra("url", message);
            cordova.getActivity().startActivity(i);
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
