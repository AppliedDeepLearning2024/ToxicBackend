package tibor.cus.toxicbackend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tibor.cus.toxicbackend.models.Chemical
import tibor.cus.toxicbackend.models.InferenceModel
import tibor.cus.toxicbackend.models.Prediction

@Repository
interface PredictionRepository: JpaRepository<Prediction, Long> {
}