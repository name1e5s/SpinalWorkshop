package workshop.counter

import spinal.core._

case class Counter(width: Int) extends Component {
  val io = new Bundle {
    val clear    = in  Bool()
    val value    = out UInt(width bits)
    val full     = out Bool()
  }
  val value_reg = Reg(UInt(width bits))
  val value_next = Mux(io.clear, U(0), value_reg + 1)

  value_reg := value_next

  io.value := value_reg
  io.full := value_reg.andR
}
