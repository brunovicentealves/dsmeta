import Header from "./assets/components/Header"
import SalesCard from "./assets/components/SalesCard"



function App() {
  return (
    <>
    <main>
    <Header/>
      <section id="sales">
        <div className="dsmeta-container">
        <SalesCard/>
        </div>
    </section>
    </main>
    </>
  
  )
  
}

export default App
