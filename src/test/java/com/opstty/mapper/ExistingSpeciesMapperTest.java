package com.opstty.mapper;

        import com.opstty.mapper.DistrictContainingTreesMapper;
        import org.apache.hadoop.io.IntWritable;
        import org.apache.hadoop.io.Text;
        import org.apache.hadoop.mapreduce.Mapper;
        import org.junit.Before;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.Mock;
        import org.mockito.runners.MockitoJUnitRunner;

        import java.io.IOException;

        import static org.apache.avro.SchemaBuilder.map;
        import static org.junit.Assert.assertEquals;
        import static org.mockito.Mockito.times;
        import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ExistingSpeciesMapperTest {
    @Mock
    private Mapper.Context context;
    private ExistingSpeciesMapper existingSpeciesMapperTest;

    @Before
    public void setup() {
        this.existingSpeciesMapperTest = new ExistingSpeciesMapper();
    }

    @Test
    public void testMap() throws IOException, InterruptedException {
        String value = "GEOPOINT;ARRONDISSEMENT;GENRE;ESPECE;FAMILLE;ANNEE PLANTATION;HAUTEUR;CIRCONFERENCE;ADRESSE;NOM COMMUN;VARIETE;OBJECTID;NOM_EV\n" +
                "(48.857140829, 2.29533455314);7;Maclura;pomifera;Moraceae;1935;13.0;;Quai Branly, avenue de La Motte-Piquet, avenue de la Bourdonnais, avenue de Suffren;Oranger des Osages;;6;Parc du Champs de Mars\n" +
                "(48.8685686134, 2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées\n" +
                "(48.8768191638, 2.33210374339);9;Pterocarya;fraxinifolia;Juglandaceae;1862;22.0;330.0;Place d'Estienne-d'Orves;Pérocarya du Caucase;;14;Square Etienne d'Orves\n";

        this.existingSpeciesMapperTest.map(null, new Text(value), this.context);
        verify(this.context, times(3))
                .write(new Text("fraxinifolia"), new IntWritable(1));
    }
}