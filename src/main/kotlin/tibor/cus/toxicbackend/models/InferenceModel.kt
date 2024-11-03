package tibor.cus.toxicbackend.models

import jakarta.persistence.*

@Entity(name = "inferencemodel")
data class InferenceModel (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(unique=true) var smile: String
)