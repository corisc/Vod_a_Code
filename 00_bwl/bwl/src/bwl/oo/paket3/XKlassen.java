package bwl.oo.paket3;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class XKlassen {
    String klasse;
    ArrayList<String> instanzVariablenBeschriftung = new ArrayList<>();
    ArrayList<String> instanzVariableWert = new ArrayList<>();
    public String getInfo(){
        String info=instanzVariableWert.stream().map(n -> String.valueOf(n))
                    .collect(Collectors.joining("-", "{", "}"));
        return info;
    }
}

