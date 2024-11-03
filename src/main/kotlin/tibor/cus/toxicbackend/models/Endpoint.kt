package tibor.cus.toxicbackend.models

import jakarta.persistence.*

@Entity(name = "endpoint")
data class Endpoint (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(unique=true)  var name: String
)