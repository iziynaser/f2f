package ir.verjik.model;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoggingModel {
    private String timeStamp ;
    private String className ;
    private String methodName ;
    private long executionTime ;
    private String level ;
    private String message ;
    private String extendedInformation ;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
