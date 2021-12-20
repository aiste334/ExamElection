package exam.project.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Getter
    @Setter
    @Entity
    @NoArgsConstructor
    @Table(name = "party", schema = "examelection")
    public class Party {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "party_id", nullable = false, length = 10)
        private int partyId;
        @Basic
        @Column(name = "party_name", nullable = false, length = 45)
        private String partyName;
        @Basic
        @Column(name = "party_votes", nullable = false, length = 10)
        private String email;


        public Party(String partyName, String email) {
            this.partyName = partyName;
            this.email = email;
        }
    }


