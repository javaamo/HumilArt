package entity;

import entity.Entrega;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-12T17:41:00")
@StaticMetamodel(Comic.class)
public class Comic_ { 

    public static volatile SingularAttribute<Comic, String> descripcion;
    public static volatile SingularAttribute<Comic, Integer> idComic;
    public static volatile CollectionAttribute<Comic, Entrega> entregaCollection;
    public static volatile SingularAttribute<Comic, String> nombre;

}