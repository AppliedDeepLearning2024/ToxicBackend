package tibor.cus.toxicbackend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tibor.cus.toxicbackend.models.Endpoint

@Repository
interface EndpointRepository: JpaRepository<Endpoint, Long> {
}