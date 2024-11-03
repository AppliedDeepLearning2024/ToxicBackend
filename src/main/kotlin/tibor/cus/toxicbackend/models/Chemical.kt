package tibor.cus.toxicbackend.models

import jakarta.persistence.*

@Entity(name = "chemical")
data class Chemical (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(unique=true) var smile: String
)