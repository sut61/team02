package sut.sa.g6.entity;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
@Entity
@Data
@Table(name = "SaveHistory")
public class SaveHistory {
    @Id
    @SequenceGenerator(name="SaveHistory_seq",sequenceName="SaveHistory_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SaveHistory_seq")
    @Column(name="SaveHistory_ID")
    private @NonNull Long Id;







    }
