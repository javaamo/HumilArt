package entity;

import entity.Comic;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-12T17:52:39")
@StaticMetamodel(Entrega.class)
public class Entrega_ { 

    public static volatile SingularAttribute<Entrega, byte[]> archivo;
    public static volatile SingularAttribute<Entrega, Comic> idComic;
    public static volatile SingularAttribute<Entrega, String> nombre;
    public static volatile SingularAttribute<Entrega, Integer> idEntrega;

}