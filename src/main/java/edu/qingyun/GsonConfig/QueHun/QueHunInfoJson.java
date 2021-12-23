package edu.qingyun.GsonConfig.QueHun;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueHunInfoJson {

    @Expose(serialize = true, deserialize = true)
    public String id;

    @Expose(serialize = true, deserialize = true)
    public String nickname;

    @Expose(serialize = true, deserialize = true)
    public JsonObject level;

    @Expose(serialize = true, deserialize = true)
    public String latest_timestamp;
}
