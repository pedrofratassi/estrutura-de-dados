package Preconditions;

import static com.google.common.base.Preconditions.checkArgument;
public class Boletim  implements Sistema {

    private static final int MAX_PRESENCA = 75;

    @Override
    public void computarPresenca(int presenca){
        checkArgument(presenca > MAX_PRESENCA, "Minimo de Participação na Sala de Aula é: " + MAX_PRESENCA);
    }
}
