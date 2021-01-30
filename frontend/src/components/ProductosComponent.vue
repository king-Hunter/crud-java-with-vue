<template>
  <div class="tproducto">
    <b-container>
      <b-row class="py-5">
        <b-col cols="12">
          <b-container class="py-3">
            <b-col cols-12> <h1>Tabla de Productos</h1> </b-col>
            <b-col cols="12">
              <b-alert v-if="guardado" class="alertas" variant="success" show>{{
                mesaje
              }}</b-alert>
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
            <br />
            <b-form-select
              v-model="selected"
              :options="options"
            ></b-form-select>
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
      selected: null,
      options: [{ value: null, text: "Please select an option" }],
      mesaje: null,
      todos: [],
      show: false,
      loaderAcciones: false,
      fields: [
        { key: "idProducto", label: "#" },
        { key: "nombre", label: "Producto" },
        "Acciones",
      ],
      producto: {
        idProducto: null,
        nombre: null,
        activo: true,
        idTipoProducto : null
      },
      guardado: false,
    };
  },
  created() {
    this.getTipos();
  },
  mounted() {
    this.getproduc();
  },
  methods: {
    cerrarModal() {
      this.show = false;
    },
    getproduc() {
      this.$http
        .get(this.$api + "producto/obtener")
        .then((Response) => {
          this.todos = Response.data.data;
        })
        .catch((e) => console.log(e));
    },
    getTipos() {
      this.$http
        .get(this.$api + "tipo/producto/obtener")
        .then((Response) => {
          Response.data.data.forEach((element) => {
            this.options.push({
              value: element.idTipoProducto,
              text: element.nombre
            });
          });
        })
        .catch((e) => console.log(e));
    },
    editar(item) {
      this.producto = item;
      this.selected = item.idTipoProducto;
      this.show = true;
    },
    desabilitar(item) {
      this.$http
        .delete(
          this.$api +
            "producto/eliminar?idProducto=" +
            item.idProducto
        )
        .then((respuesta) => {
          if (respuesta.data.data) {
            this.mesaje = respuesta.data.message;
            this.guardado = true;
            this.getproduc();
            setTimeout(() => (this.guardado = false), 1000);
          }
        })
        .finally();
    },
    agregar() {
      this.show = true;
      this.producto = {
        idProducto: this.todos.length + 1,
        nombre: null,
        activo: true,
        idTipoProducto : this.selected
        
      };
    },
    guardar() {
      this.producto.idTipoProducto=this.selected;
      this.loaderAcciones = true;
      this.$http
        .post(this.$api + "producto/guardar", this.producto)
        .then((respuesta) => {
          this.mesaje = respuesta.data.message;
          this.guardado = true;
          this.getproduc();
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
.alertas {
  position: relative;
}
</style>
