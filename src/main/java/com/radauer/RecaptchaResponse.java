package com.radauer;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Created by rad on 09.05.2017.
 */
public class RecaptchaResponse
{
    public boolean success;

    @JsonProperty(value = "error-codes")
    public List<String> errorCodes;

    @Override
    public String toString()
    {
        return "RecaptchaResponse{" + "success=" + success + ", errorCodes=" + errorCodes + '}';
    }
}
