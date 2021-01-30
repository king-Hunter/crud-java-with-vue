<template>
  <div id="app">
  <b-navbar type="dark" variant="dark">
    <b-navbar-nav>
      <router-link to="/"><b-navbar-brand href="/"> Mi Almacen de productos </b-navbar-brand></router-link>

      <!-- Navbar dropdowns -->
      <b-nav-item-dropdown text="Producto" right>
          <router-link to="/Producto"><b-dropdown-item href="/Producto">Productos</b-dropdown-item></router-link>
          <router-link to="/Tproducto" ><b-dropdown-item href="/Tproducto">Tipo de productos</b-dropdown-item></router-link>
        </b-nav-item-dropdown>

      <b-nav-item-dropdown text="Almacen" right>  
          <router-link to="/almacen"><b-dropdown-item href="/alamacen">Almacenado</b-dropdown-item></router-link>
          <router-link to="/talmacen" ><b-dropdown-item href="/talamacen">Almacen</b-dropdown-item></router-link>
        </b-nav-item-dropdown>
    </b-navbar-nav>
  </b-navbar>

  
    <router-view />
  </div>
</template>

<style lang="scss">


a:hover {
    text-decoration: none !important;
}


.dropdown-item:focus {
    color: #16181b;
    text-decoration: none;
    background-color: #e9ecef;
}


#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
