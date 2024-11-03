package tibor.cus.toxicbackend.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
import java.sql.Timestamp

@Entity
data class Prediction (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @OneToOne
    var model: InferenceModel,
    @OneToOne
    var endpoint: Endpoint,
    @OneToOne
    var chemical: Chemical,
    var created_at: Timestamp
)