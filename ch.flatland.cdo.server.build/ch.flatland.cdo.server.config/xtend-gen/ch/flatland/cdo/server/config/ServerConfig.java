package ch.flatland.cdo.server.config;

import ch.flatland.cdo.model.config.Authenticator;
import ch.flatland.cdo.model.config.AuthenticatorType;
import ch.flatland.cdo.model.config.Binding;
import ch.flatland.cdo.model.config.Config;
import ch.flatland.cdo.model.config.ConfigFactory;
import ch.flatland.cdo.model.config.DataStore;
import ch.flatland.cdo.model.config.StoreType;
import com.google.common.base.Objects;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class ServerConfig {
  private final static Logger logger = LoggerFactory.getLogger(ServerConfig.class);
  
  private final static String SYSTEM_PARAM = "ch.flatland.cdo.server.config";
  
  private final static String FILE_PATH = System.getProperty(ServerConfig.SYSTEM_PARAM);
  
  private static Config CONFIG = null;
  
  private ServerConfig() {
  }
  
  public static synchronized Config getConfig() {
    boolean _equals = Objects.equal(ServerConfig.CONFIG, null);
    if (_equals) {
      try {
        final String configFile = ServerConfig.readFile(ServerConfig.FILE_PATH);
        final JsonParser parser = new JsonParser();
        JsonElement _parse = parser.parse(configFile);
        final JsonObject jsonObject = ((JsonObject) _parse);
        final Config template = ServerConfig.getDefault();
        EClass _eClass = template.eClass();
        EList<EReference> _eAllReferences = _eClass.getEAllReferences();
        final Procedure1<EReference> _function = new Procedure1<EReference>() {
          public void apply(final EReference it) {
            Object _eGet = template.eGet(it);
            final EObject eObject = ((EObject) _eGet);
            String _name = it.getName();
            JsonElement _get = jsonObject.get(_name);
            final JsonObject jsonDetailObject = ((JsonObject) _get);
            String _name_1 = it.getName();
            ServerConfig.logger.debug("Read config object \'{}\'", _name_1);
            boolean _notEquals = (!Objects.equal(jsonDetailObject, null));
            if (_notEquals) {
              EClass _eClass = eObject.eClass();
              EList<EAttribute> _eAllAttributes = _eClass.getEAllAttributes();
              final Procedure1<EAttribute> _function = new Procedure1<EAttribute>() {
                public void apply(final EAttribute it) {
                  EDataType _eAttributeType = it.getEAttributeType();
                  Class<?> _instanceClass = _eAttributeType.getInstanceClass();
                  boolean _matched = false;
                  if (!_matched) {
                    if (Objects.equal(_instanceClass, String.class)) {
                      _matched=true;
                      String _name = it.getName();
                      JsonElement _get = jsonDetailObject.get(_name);
                      boolean _notEquals = (!Objects.equal(_get, null));
                      if (_notEquals) {
                        String _name_1 = it.getName();
                        JsonElement _get_1 = jsonDetailObject.get(_name_1);
                        String _asString = _get_1.getAsString();
                        eObject.eSet(it, _asString);
                      } else {
                        String _name_2 = it.getName();
                        ServerConfig.logger.debug("Json primitive \'{}\' not found", _name_2);
                      }
                    }
                  }
                  if (!_matched) {
                    if (Objects.equal(_instanceClass, boolean.class)) {
                      _matched=true;
                      String _name_3 = it.getName();
                      JsonElement _get_2 = jsonDetailObject.get(_name_3);
                      boolean _notEquals_1 = (!Objects.equal(_get_2, null));
                      if (_notEquals_1) {
                        String _name_4 = it.getName();
                        JsonElement _get_3 = jsonDetailObject.get(_name_4);
                        boolean _asBoolean = _get_3.getAsBoolean();
                        eObject.eSet(it, Boolean.valueOf(_asBoolean));
                      } else {
                        String _name_5 = it.getName();
                        ServerConfig.logger.debug("Json primitive \'{}\' not found", _name_5);
                      }
                    }
                  }
                  EDataType _eAttributeType_1 = it.getEAttributeType();
                  if ((_eAttributeType_1 instanceof EEnum)) {
                    EDataType _eAttributeType_2 = it.getEAttributeType();
                    final EEnum enum_ = ((EEnum) _eAttributeType_2);
                    String _name_6 = it.getName();
                    JsonElement _get_4 = jsonDetailObject.get(_name_6);
                    boolean _notEquals_2 = (!Objects.equal(_get_4, null));
                    if (_notEquals_2) {
                      String _name_7 = it.getName();
                      JsonElement _get_5 = jsonDetailObject.get(_name_7);
                      String _asString_1 = _get_5.getAsString();
                      final EEnumLiteral literal = enum_.getEEnumLiteral(_asString_1);
                      boolean _notEquals_3 = (!Objects.equal(literal, null));
                      if (_notEquals_3) {
                        Enumerator _instance = literal.getInstance();
                        eObject.eSet(it, _instance);
                      } else {
                        String _name_8 = it.getName();
                        ServerConfig.logger.debug("Json primitive \'{}\' not found", _name_8);
                      }
                    } else {
                      String _name_9 = it.getName();
                      ServerConfig.logger.debug("Json primitive \'{}\' not found", _name_9);
                    }
                  }
                  String _name_10 = it.getName();
                  Object _eGet = eObject.eGet(it);
                  ServerConfig.logger.debug("Value \'{}\' = \'{}\'", _name_10, _eGet);
                }
              };
              IterableExtensions.<EAttribute>forEach(_eAllAttributes, _function);
            } else {
              String _name_2 = it.getName();
              ServerConfig.logger.debug("Config object \'{}\' not found", _name_2);
            }
          }
        };
        IterableExtensions.<EReference>forEach(_eAllReferences, _function);
        ServerConfig.CONFIG = template;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          ServerConfig.logger.debug("Could not read config file!", e);
          Config _default = ServerConfig.getDefault();
          ServerConfig.CONFIG = _default;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    return ServerConfig.CONFIG;
  }
  
  private static String readFile(final String filePath) {
    try {
      FileReader _fileReader = new FileReader(filePath);
      final BufferedReader reader = new BufferedReader(_fileReader);
      try {
        final StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while ((!Objects.equal(line, null))) {
          {
            builder.append(line);
            String _lineSeparator = System.lineSeparator();
            builder.append(_lineSeparator);
            String _readLine = reader.readLine();
            line = _readLine;
          }
        }
        return builder.toString();
      } finally {
        reader.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static Config getDefault() {
    final Config config = ConfigFactory.eINSTANCE.createConfig();
    DataStore _createDataStore = ConfigFactory.eINSTANCE.createDataStore();
    final Procedure1<DataStore> _function = new Procedure1<DataStore>() {
      public void apply(final DataStore it) {
        it.setStoreType(StoreType.H2);
        it.setRepositoryName("repo");
        it.setConnectionUrl("jdbc:h2:database/");
        it.setUserName("cdo");
        it.setPassword("cdo");
      }
    };
    final DataStore dataStore = ObjectExtensions.<DataStore>operator_doubleArrow(_createDataStore, _function);
    Authenticator _createAuthenticator = ConfigFactory.eINSTANCE.createAuthenticator();
    final Procedure1<Authenticator> _function_1 = new Procedure1<Authenticator>() {
      public void apply(final Authenticator it) {
        it.setAuthenticatorType(AuthenticatorType.LDAP);
        it.setConnectionUrl("faked://flatland.ch:333");
        it.setDomainBase("ou=person,o=FLATLAND,c=CH");
        it.setUserIdField("empid");
        it.setReadOnlyPassword("password");
        it.setAdminPassword("password");
      }
    };
    final Authenticator authenticator = ObjectExtensions.<Authenticator>operator_doubleArrow(_createAuthenticator, _function_1);
    Binding _createBinding = ConfigFactory.eINSTANCE.createBinding();
    final Procedure1<Binding> _function_2 = new Procedure1<Binding>() {
      public void apply(final Binding it) {
        it.setIp("0.0.0.0");
        it.setTcp(true);
        it.setTcpPort("2036");
        it.setHttp(true);
        it.setHttpPort("8080");
      }
    };
    final Binding binding = ObjectExtensions.<Binding>operator_doubleArrow(_createBinding, _function_2);
    config.setDataStore(dataStore);
    config.setAuthenticator(authenticator);
    config.setBinding(binding);
    return config;
  }
}
