<template>
  <div class="tproducto">
    <b-container>
      <b-row class="py-5">
        <b-col cols="12">
          <b-container class="py-3">
            <b-col cols-12> <h1>Tabla de Tipo de Productos</h1> </b-col>
            <b-col cols="12">
                    <b-alert v-if="guardado" class="alertas" variant="success" show>{{mesaje}}</b-alert>
                </b-col>
            <b-col cols="3">
              <b-button variant="primary" @click="agregar()"
                >Agregar Nuevo Tipo
              </b-button>
            </b-col></b-container
          >
        </b-col>
        <b-col>
          <b-table striped hover :items="todos" :fields="fields">
            <template v-slot:cell(Acciones)="row">
              <b-row>
                <b-col lg="4"> </b-col>
                <b-col lg="2" class="pb-2"
                  ><b-button variant="warning" @click="editar(row.item)"
                    >Editar</b-button
                  ></b-col
                >
                <b-col v-if="row.item.activo" lg="2" class="pb-2"
                  ><b-button variant="danger" @click="desabilitar(row.item)"
                    >Desabilitar</b-button
                  ></b-col
                >
                <b-col v-else lg="2" class="pb-2"
                  ><b-button variant="info" @click="desabilitar(row.item)"
                    >Restaurar</b-button
                  ></b-col
                >
              </b-row>
            </template>
          </b-table>
        </b-col>
      </b-row>
    </b-container>
    <b-modal v-model="show" id="modal-1" title="BootstrapVue">
      <div slot="modal-header">
        <h3>Tipo de Producto</h3>
      </div>
      <b-container>
        <b-row>
          <b-col>
            <b-form-input
              id="input-live"
              v-model="producto.nombre"
              aria-describedby="input-live-help input-live-feedback"
              placeholder="Nombre del tipo del producto"
              trim
            ></b-form-input>
          </b-col>
        </b-row>
      </b-container>
      <div slot="modal-footer">
        <b-row>
          <b-col>
            <b-button
              :disabled="loaderAcciones"
              @click="guardar()"
              variant="outline-primary"
            >
              <span v-if="!loaderAcciones">Guardar</span>
              <span v-if="loaderAcciones">
                <b-spinner small></b-spinner>
                Cargando...
              </span>
            </b-button></b-col
          >

          <b-col>
            <b-button
              variant="outline-danger"
              :disabled="loaderAcciones"
              @click="cerrarModal()"
              >Cancelar</b-button
            >
          </b-col>
        </b-row>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts">
export default {
  data() {
    return {
      mesaje: null,
      todos: [],
      show: false,
      loaderAcciones: false,
      fields: [
        { key: "idTipoProducto", label: "#" },
        { key: "nombre", label: "Nombre del tipo del producto" },
        "Acciones",
      ],
      producto: {
        idTipoProducto: null,
        nombre: null,
        activo: true,
      },
      guardado: false,
    };
  },
  mounted() {
    this.getTodos();
  },
  methods: {
    cerrarModal() {
      this.show = false;
    },
    getTodos() {
      this.$http
        .get(this.$api + "tipo/producto/obtener")
        .then((Response) => {
          this.todos = Response.data.data;
          this.mesaje = Response.data.message;
        })
        .catch((e) => console.log(e));
    },
    editar(item) {
      this.producto = item;
      this.show = true;
    },
    desabilitar(item) {
      this.$http
        .delete(
          this.$api +
            "tipo/producto/eliminar?idTipoProducto=" +
            item.idTipoProducto
        )
        .then((respuesta) => {
          if (respuesta.data.data) {
            this.mesaje = respuesta.data.message;
            this.guardado = true;
            this.getTodos();
            setTimeout(() => (this.guardado = false), 1000)
          }
        })
        .finally();
    },
    agregar() {
      this.show = true;
      this.producto = {
        idTipoProducto: (this.todos.length+1),
        nombre: null,
        activo: true,
      };
    },
    guardar() {
      this.loaderAcciones = true;
      this.$http
        .post(this.$api + "tipo/producto/guardar", this.producto)
        .then((respuesta) => {
          this.mesaje = respuesta.data.message;
          this.guardado = true;
          this.getTodos();
          setTimeout(() => (this.guardado = false), 1000);
          this.show = false;
        })
        .catch((error) => {
          this.mesaje = error;
        })
        .finally(() => {
          this.loaderAcciones = false;
        });
    },
  },
};
</script>

<style scoped lang="scss">
.alertas{
  position: relative;
}
</style>
