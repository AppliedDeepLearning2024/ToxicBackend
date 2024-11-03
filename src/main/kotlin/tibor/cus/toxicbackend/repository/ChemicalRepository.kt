package tibor.cus.toxicbackend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tibor.cus.toxicbackend.models.Chemical

@Repository
interface ChemicalRepository : JpaRepository<Chemical, Long> {
    fun findBySmile(smile: String): Chemical?
}