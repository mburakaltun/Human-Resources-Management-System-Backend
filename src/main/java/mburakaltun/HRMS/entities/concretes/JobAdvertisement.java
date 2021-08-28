package mburakaltun.HRMS.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "job_advertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_wage")
    private double minWage;

    @Column(name = "max_wage")
    private double maxWage;

    @Column(name = "open_position_count")
    private int openPositionCount;

    @Column(name = "publishing_date")
    private Date publishingDate;

    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne()
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
